package tw.fili.viewpagerdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<SampleItem> rData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 測試用的資料
        rData = new ArrayList<>();
        rData.add( new SampleItem("名稱1","描述1", 100, R.drawable.sample_a1) );
        rData.add( new SampleItem("名稱2","描述描述2", 20, R.drawable.sample_a2) );
        rData.add( new SampleItem("名稱3","描述描述描述3", 10000, R.drawable.sample_a3) );
        rData.add( new SampleItem("名稱4","描述4", 1, R.drawable.sample_a4) );

        //顯示第 0 頁的值
        SampleItem x = rData.get(0);

        ImageView iv;
        TextView tv1,tv2,tv3;
        iv = findViewById(R.id.imageView2);
        tv1 = findViewById(R.id.textView4);
        tv2 = findViewById(R.id.textView5);
        tv3 = findViewById(R.id.textView6);

        iv.setImageResource( x.getImage_id() );
        tv1.setText( x.getName() );
        tv2.setText( x.getDesc() );
        tv3.setText( String.valueOf(x.getCount()) );

        //綁定adapter
        ViewPager vp = findViewById(R.id.viewPager);
        vp.setAdapter(new MyViewPagerAdapter());

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                SampleItem x = rData.get(position);

                ImageView iv;
                TextView tv1,tv2,tv3;
                iv = findViewById(R.id.imageView2);
                tv1 = findViewById(R.id.textView4);
                tv2 = findViewById(R.id.textView5);
                tv3 = findViewById(R.id.textView6);

                iv.setImageResource( x.getImage_id() );
                tv1.setText( x.getName() );
                tv2.setText( x.getDesc() );
                tv3.setText( String.valueOf(x.getCount()) );
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        findViewById(R.id.button2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewPager vp = findViewById(R.id.viewPager);
                vp.setCurrentItem(2);   // 切換到第 2 頁
            }
        });

    }


    class MyViewPagerAdapter extends PagerAdapter {

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {

            SampleItem x = rData.get(position);

            View v = LayoutInflater
                        .from(container.getContext())
                        .inflate(R.layout.viewpager_item, container, false);

            ImageView iv;
            TextView tv, tv2, tv3;
            iv = v.findViewById(R.id.imageView);
            tv  = v.findViewById(R.id.textView);
            tv2 = v.findViewById(R.id.textView2);
            tv3 = v.findViewById(R.id.textView3);

            iv.setImageResource( x.getImage_id() );
            tv .setText( x.getName() );
            tv2.setText( x.getDesc() );
            tv3.setText( String.valueOf(x.getCount()) );

            container.addView(v);
            return  v;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View)object);
        }

        @Override
        public int getCount() {
            return rData.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return (view==object);
        }
    }
}
