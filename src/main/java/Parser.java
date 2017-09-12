import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Аглиуллины on 03.09.2017.
 */
public class Parser {
    public List<String> imageList = new ArrayList<>();
    public Integer likesCount=0;
    public Integer repostCount=0;
    public void getPostId(){
        try {
            Document doc = Jsoup.connect("https://vk.com/unwebsiteinrussian").get();
            Element masthead = doc.select("div._post").first();
            getCountsLikesAndReposts(1,doc);
            getVideoPostFormIndex(1,doc);
             } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getPostText(Element element){
         Elements in = element.getElementsByClass("wall_post_text");
        System.out.println(in.get(0).text());


    }

    public void getPostImages(Document doc){
        Element element = doc.select("div.page_post_sized_thumbs").first();
        Elements in = element.getElementsByTag("a");
        for (Element el:in
             ) {
            Attributes attributes = el.attributes();
            List<Attribute> attributeList = attributes.asList();
             attributeList.stream().forEach(a->{
                 imageList.add(parsingWihRegex(a.getValue(),"url\\((.*?)\\)",4,1));
//                 Pattern pattern = Pattern.compile("url\\((.*?)\\)");
//                 Matcher m = pattern.matcher(a.getValue());
//                 if(m.find()){
//                     String imageLink = m.group(0).substring(4,m.group(0).length()-1);
//                     imageList.add(imageLink);
//                     System.out.println(imageLink);
               //  }
             });

        }
    }



    public void getTextPostFormIndex(int index,Document document){
        Elements elements = document.select("div._post.post.page_block.all.own");
           Element wallText =elements.get(index).getElementsByClass("wall_post_text").get(0);
        System.out.println(wallText.text());
    }


    public void getCountsLikesAndReposts(int index,Document document){

        Elements elements = document.select("div._post.post.page_block.all.own");
        Element likesInfo =elements.get(index).getElementsByClass("_post_content").get(0)
               .getElementsByClass("post_content").get(0)
               .getElementsByClass("post_info").get(0)
               .getElementsByClass("post_full_like_wrap").get(0)
                .getElementsByClass("post_like_count").get(0);
                likesCount= Integer.valueOf(likesInfo.text());
        System.out.println(likesCount);

        Element repostInfo =elements.get(index).getElementsByClass("_post_content").get(0)
                .getElementsByClass("post_content").get(0)
                .getElementsByClass("post_info").get(0)
                .getElementsByClass("post_full_like_wrap").get(0)
                .getElementsByClass("post_share_count").get(0);
        repostCount= Integer.valueOf(repostInfo.text());
        System.out.println(repostCount);
    }


    public void getVideoPostFormIndex(int index,Document document){
        Elements elements = document.select("div._post.post.page_block.all.own");
             Element wallVideo =elements.get(index).getElementsByClass("_post_content").get(0)
                      .getElementsByClass("post_content").get(0)
                     .getElementsByClass("post_info").get(0)
                     .getElementsByClass("wall_text").get(0)
                     .getElementsByClass("post_video_desc")
                     .get(0);
//
        System.out.println(parsingWihRegex(wallVideo.toString(),"href=\"\\/video(.*?)\\\"",6,1));
    }

    public String parsingWihRegex(String input,String regex, int start, int end){
        String result=null;
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(input);
        if(m.find()){
            result= m.group(0).substring(start,m.group(0).length()-end);


        }
        return result;
    }

    public void getFirstFivePosts(Document document){
        Elements elements = document.select("div._post.post.page_block.all.own");
         for (int i=0;i<5;i++)
        System.out.println(elements.get(i).text());
    }


}
