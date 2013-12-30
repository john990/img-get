downloader
==========

java muti thread download image from internet.


how to use
==========
[ImgGetTest.java](https://github.com/kai-wang-john/http-get/blob/master/test/com/get/test/ImgGetTest.java)

    import com.get.ImgGet;
    import com.get.info.DownloadInfo;
    
    public class ImgGetTest {
    	public static String[] urls = {
    			"http://img.hb.aicdn.com/2c3b0af90a2620d7fb08dcf1c787244cea26c848195e4-AGsUNg_fw236",
    			"http://img.hb.aicdn.com/7e615f1ef19dd6ee342be2dd917b2b38759cc83c10931-y0T1M8_fw236",
    			"http://img.hb.aicdn.com/89f4b6c0226221e6401d2a4d44b160b1185229298374-8wspgi_fw236",
    			"http://img.hb.aicdn.com/ca51eedf51f337ea3a5d73a01fd5d0bce5e3cca16f2fe-g436qJ_fw236",
    			"http://img.hb.aicdn.com/e9bb779534da1c43d6ca6e49cfb5e972517c720013f87-36OAhB_fw236",
    			"http://img.hb.aicdn.com/c0d918954f26a7d8b9b4ed42d964b581a21983a67c99e-trVNoz_fw236"
    	};
    
    	public static void main(String[] args){
    		ImgGetTest test = new ImgGetTest();
    		ImgGet wget = new ImgGet.Builder()
    							.setThreadPoolSize(4)
    							.setOutputFloder("/img-get/")
    							.build();
    		for(int i=0;i<urls.length;i++){
    			DownloadInfo downloadInfo = new DownloadInfo();
    			downloadInfo.setUrl(urls[i]);
    			downloadInfo.setOutputName(i+"");
    			downloadInfo.setFlag(i);
    			wget.addTask(downloadInfo);
    		}
    		wget.shutdown();
    	}
    }
