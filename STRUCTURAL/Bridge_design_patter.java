// Implementor Interface
interface VideoQuality {
    void playVideo();
}

// Concrete Implementors
class HDVideo implements VideoQuality {
    @Override
    public void playVideo() {
        System.out.println("Playing HD Video");
    }
}

class _4KVideo implements VideoQuality {
    @Override
    public void playVideo() {
        System.out.println("Playing 4K Video");
    }
}

class SimpleVideo implements VideoQuality {
    @Override
    public void playVideo() {
        System.out.println("Playing Simple Video");
    }
}

// Abstraction
abstract class StreamingService {
    protected VideoQuality videoQuality;

    protected StreamingService(VideoQuality videoQuality) {
        this.videoQuality = videoQuality;
    }

    abstract void watch();
}

// Refined Abstractions
class YouTube extends StreamingService {
    public YouTube(VideoQuality videoQuality) {
        super(videoQuality);
    }

    @Override
    void watch() {
        System.out.print("Watching YouTube: ");
        videoQuality.playVideo();
    }
}

class Netflix extends StreamingService {
    public Netflix(VideoQuality videoQuality) {
        super(videoQuality);
    }

    @Override
    void watch() {
        System.out.print("Watching Netflix: ");
        videoQuality.playVideo();
    }
}

class PrimeVideo extends StreamingService {
    public PrimeVideo(VideoQuality videoQuality) {
        super(videoQuality);
    }

    @Override
    void watch() {
        System.out.print("Watching Prime Video: ");
        videoQuality.playVideo();
    }
}

// Client Code
public class Client {
    public static void main(String[] args) {
        VideoQuality hdVideo = new HDVideo();
        VideoQuality _4kVideo = new _4KVideo();
        VideoQuality simpleVideo = new SimpleVideo();

        StreamingService youTubeHD = new YouTube(hdVideo);
        youTubeHD.watch();  // Watching YouTube: Playing HD Video

        StreamingService netflix4K = new Netflix(_4kVideo);
        netflix4K.watch();  // Watching Netflix: Playing 4K Video

        StreamingService primeVideoSimple = new PrimeVideo(simpleVideo);
        primeVideoSimple.watch();  // Watching Prime Video: Playing Simple Video
    }
}
