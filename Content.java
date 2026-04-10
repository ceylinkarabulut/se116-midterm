public abstract class Content{
    private int id;
    private String title;
    private int duration;

    Content(int id, String title, int duration){
        this.id = id;
        this.title = title;
        this.duration = duration;
    }
    public int getId() {
        return id;
    }   
    public String getTitle() {
        return title;
    }
    public int getDuration() {
        return duration;
    }   
    public String displayContent(){
        return "ID: " + id + ", Title: " + title + ", Duration: " + duration;
    }
    public String getInfo(){
        return "ID: " + id + ", Title: " + title + ", Duration: " + duration;
    }

    interface Downloadable{
        boolean isDownloadable();
        public String download();
    }
    interface DurationOperation{
        int apply(int duration);
    }
    interface ContentFilter{  
    }
}

class VideoLesson extends Content implements Content.Downloadable, Content.DurationOperation{
    private String videoQuality;
    private boolean downloadable;

    VideoLesson(int id, String title, int duration, String videoQuality, boolean downloadable){
        super(id, title, duration);
        this.videoQuality = videoQuality;
        this.downloadable = downloadable;
    }
    public String getVideoQuality() {
        return videoQuality;
    }
       @Override
    public String getInfo() {
        return super.getInfo();
    }
      @Override
    public String displayContent() {
     return "ID: " + super.getId() + ", Title: " + super.getTitle() + ", Duration: " + super.getDuration();
    }

    @Override
      public int apply(int duration) {
        return (int)(duration);
    }

     @Override
    public boolean isDownloadable() {
        return downloadable;
    }
     @Override
    public String download() {
        if(downloadable){
            return "Downloading video.";
        } else {
            return "This video is not available for download.";
        }
    }
}

class PDFNote extends Content implements Content.Downloadable {
    private int pageCount;
    private boolean downloadable;

    PDFNote(int id, String title, int duration, int pageCount, boolean downloadable){
        super(id, title, duration);
        this.pageCount = pageCount;
        this.downloadable = downloadable;
    }
    public int getPageCount() {
        return pageCount;
    }
    @Override
    public String getInfo() {
        return super.getInfo();
    }
    @Override
    public String displayContent() {
     return "ID: " + super.getId() + ", Title: " + super.getTitle() + ", Duration: " + super.getDuration();
    }
    @Override
    public boolean isDownloadable() {
        return downloadable;
    }
    @Override
    public String download() {
        if(downloadable){
            return "Downloading PDF.";
        } else {
            return "This PDF is not available for download.";
        }
    }
}
class LiveSession extends Content implements Content.DurationOperation {
    private String schedule;

    LiveSession(int id, String title, int duration, String schedule){
        super(id, title, duration);
        this.schedule = schedule;
    }
    public String getSchedule() {
        return schedule;
    }
     @Override
      public int apply(int duration) {
        return (int)(duration);
    }
       @Override
    public String getInfo() {
        return super.getInfo();
    }
    @Override
    public String displayContent() {
     return "ID: " + super.getId() + ", Title: " + super.getTitle() + ", Duration: " + super.getDuration();
    }
}