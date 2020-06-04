package com.example.demo.Cache;

import com.example.demo.model.TagModel;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TagCache {
    public List<TagModel> gettags(){
        List<TagModel> tags=new ArrayList<>();

        TagModel language=new TagModel();
      /*  language.setCategoryname("类别");*/
        language.setTags(Arrays.asList("热血","搞笑","治愈","校园","科幻","国风","神话"));
        tags.add(language);

      /*  TagModel tools=new TagModel();
        tools.setCategoryname("文章类别");
        tools.setTags(Arrays.asList("科普","原创"));
        tags.add(tools);*/

        return tags;
    }
}
