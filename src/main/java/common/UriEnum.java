package common;

/**
 * Created by xzinoviou
 * 14/10/2018
 */
public enum UriEnum {

    MEDICINES_ALL("#/medicines/all"),
    MEDICINES_SEARCH("#/medicines/search");

    private final String view;

    UriEnum(String view){
        this.view = view;
    }

    public String getUri(){
        return view;
    }
}
