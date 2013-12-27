downloader
==========

java muti thread download file from internet


how to use
==========
    public class WgetTest implements Downloader.DownloadListener{
    	public static void main(String[] args){
    		WgetTest test = new WgetTest();
    		WGet wget = new WGet.Builder().setThreadPoolSize(4).setOutputFloder("/").setDownloadListener(test).build();
    		wget.addTask("https://www.google.com.hk/images/nav_logo170_hr.png","a.png");
    	}
    
    	@Override
    	public void onStart(DownloadInfo downloadInfo) {
    		System.out.println("start");
    	}
    
    	@Override
    	public void onFinish(DownloadInfo downloadInfo) {
    		System.out.println("finish");
    		System.exit(1);
    	}
    
    	@Override
    	public void onProgressChange(int progress) {
    		System.out.println(progress);
    	}
    
    	@Override
    	public void onFail(DownloadInfo downloadInfo) {
    		System.out.println("fail");
    		System.exit(1);
    	}
    }
