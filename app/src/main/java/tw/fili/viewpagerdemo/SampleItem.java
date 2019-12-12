package tw.fili.viewpagerdemo;

public class SampleItem {
    private String name, desc;
    private int count;
    private int image_id;  // or String url;

    public SampleItem(String name, String desc, int count, int image_id) {
        this.name = name;
        this.desc = desc;
        this.count = count;
        this.image_id = image_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }
}
