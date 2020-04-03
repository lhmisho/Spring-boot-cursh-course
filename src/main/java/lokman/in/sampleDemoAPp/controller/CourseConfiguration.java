package lokman.in.sampleDemoAPp.controller;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("course")
public class CourseConfiguration {
    private String name;
    private Integer chapterCount;
    private Double rating;
    private String Auther;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getChapterCount() {
        return chapterCount;
    }

    public void setChapterCount(Integer chapterCount) {
        this.chapterCount = chapterCount;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getAuther() {
        return Auther;
    }

    public void setAuther(String auther) {
        Auther = auther;
    }
}
