package com.example.w2;

import com.google.gson.annotations.SerializedName;

public class Media {

    @SerializedName("metadata")
    private Media-metadata[] media-metadata;

    private String subtype;

    private String type;

    private String approved_for_syndication;

    public void setCopyright (null copyright)
    {
        this.copyright = copyright;
    }

    public Media-metadata[] getMedia-metadata ()
    {
        return media-metadata;
    }

    public void setMedia-metadata (Media-metadata[] media-metadata)
    {
        this.media-metadata = media-metadata;
    }

    public String getSubtype ()
    {
        return subtype;
    }

    public void setSubtype (String subtype)
    {
        this.subtype = subtype;
    }


    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getApproved_for_syndication ()
    {
        return approved_for_syndication;
    }

    public void setApproved_for_syndication (String approved_for_syndication)
    {
        this.approved_for_syndication = approved_for_syndication;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [copyright = "+copyright+", media-metadata = "+media-metadata+", subtype = "+subtype+", caption = "+caption+", type = "+type+", approved_for_syndication = "+approved_for_syndication+"]";
    }
}
