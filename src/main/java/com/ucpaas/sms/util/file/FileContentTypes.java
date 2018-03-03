package com.ucpaas.sms.util.file;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * 获取文件对应的响应HTTP内容类型
 * 
 * @author xiejiaan
 */
public class FileContentTypes {
	public static Map<String, String> cts = new HashMap<String, String>();

	static {
		initCts();
	}

	/**
	 * 获取文件对应的响应HTTP内容类型
	 * 
	 * @param fileName
	 *            文件名
	 * @return
	 */
	public static String getContentType(String fileName) {
		if (cts.size() == 0) {
			initCts();
		}
		String extName = StringUtils.substring(fileName, fileName.lastIndexOf("."), fileName.length());
		String ct = cts.get(extName.toLowerCase());
		if (ct == null) {
			return "application/octet-stream";
		} else {
			return ct;
		}
	}

	private static void initCts() {
		cts.clear();
		cts.put(".001", "application/x-001");
		cts.put(".301", "application/x-301");
		cts.put(".323", "text/h323");
		cts.put(".906", "application/x-906");
		cts.put(".907", "drawing/907");
		cts.put(".a11", "application/x-a11");
		cts.put(".acp", "audio/x-mei-aac");
		cts.put(".ai", "application/postscript");
		cts.put(".aif", "audio/aiff");
		cts.put(".aifc", "audio/aiff");
		cts.put(".aiff", "audio/aiff");
		cts.put(".anv", "application/x-anv");
		cts.put(".asa", "text/asa");
		cts.put(".asf", "video/x-ms-asf");
		cts.put(".asp", "text/asp");
		cts.put(".asx", "video/x-ms-asf");
		cts.put(".au", "audio/basic");
		cts.put(".avi", "video/avi");
		cts.put(".awf", "application/vnd.adobe.workflow");
		cts.put(".biz", "text/xml");
		cts.put(".bmp", "application/x-bmp");
		cts.put(".bot", "application/x-bot");
		cts.put(".c4t", "application/x-c4t");
		cts.put(".c90", "application/x-c90");
		cts.put(".cal", "application/x-cals");
		cts.put(".cat", "application/vnd.ms-pki.seccat");
		cts.put(".cdf", "application/x-netcdf");
		cts.put(".cdr", "application/x-cdr");
		cts.put(".cel", "application/x-cel");
		cts.put(".cer", "application/x-x509-ca-cert");
		cts.put(".cg4", "application/x-g4");
		cts.put(".cgm", "application/x-cgm");
		cts.put(".cit", "application/x-cit");
		cts.put(".class", "java/*");
		cts.put(".cml", "text/xml");
		cts.put(".cmp", "application/x-cmp");
		cts.put(".cmx", "application/x-cmx");
		cts.put(".cot", "application/x-cot");
		cts.put(".crl", "application/pkix-crl");
		cts.put(".crt", "application/x-x509-ca-cert");
		cts.put(".csi", "application/x-csi");
		cts.put(".css", "text/css");
		cts.put(".cut", "application/x-cut");
		cts.put(".dbf", "application/x-dbf");
		cts.put(".dbm", "application/x-dbm");
		cts.put(".dbx", "application/x-dbx");
		cts.put(".dcd", "text/xml");
		cts.put(".dcx", "application/x-dcx");
		cts.put(".der", "application/x-x509-ca-cert");
		cts.put(".dgn", "application/x-dgn");
		cts.put(".dib", "application/x-dib");
		cts.put(".dll", "application/x-msdownload");
		cts.put(".doc", "application/msword");
		cts.put(".dot", "application/msword");
		cts.put(".drw", "application/x-drw");
		cts.put(".dtd", "text/xml");
		cts.put(".dwf", "application/x-dwf");
		cts.put(".dwg", "application/x-dwg");
		cts.put(".dxb", "application/x-dxb");
		cts.put(".dxf", "application/x-dxf");
		cts.put(".edn", "application/vnd.adobe.edn");
		cts.put(".emf", "application/x-emf");
		cts.put(".eml", "message/rfc822");
		cts.put(".ent", "text/xml");
		cts.put(".epi", "application/x-epi");
		cts.put(".eps", "application/postscript");
		cts.put(".etd", "application/x-ebx");
		cts.put(".exe", "application/x-msdownload");
		cts.put(".fax", "image/fax");
		cts.put(".fdf", "application/vnd.fdf");
		cts.put(".fif", "application/fractals");
		cts.put(".fo", "text/xml");
		cts.put(".frm", "application/x-frm");
		cts.put(".g4", "application/x-g4");
		cts.put(".gbr", "application/x-gbr");
		cts.put(".gcd", "application/x-gcd");
		cts.put(".gif", "image/gif");
		cts.put(".gl2", "application/x-gl2");
		cts.put(".gp4", "application/x-gp4");
		cts.put(".hgl", "application/x-hgl");
		cts.put(".hmr", "application/x-hmr");
		cts.put(".hpg", "application/x-hpgl");
		cts.put(".hpl", "application/x-hpl");
		cts.put(".hqx", "application/mac-binhex40");
		cts.put(".hrf", "application/x-hrf");
		cts.put(".hta", "application/hta");
		cts.put(".htc", "text/x-component");
		cts.put(".htm", "text/html");
		cts.put(".html", "text/html");
		cts.put(".htt", "text/webviewhtml");
		cts.put(".htx", "text/html");
		cts.put(".icb", "application/x-icb");
		cts.put(".ico", "image/x-icon");
		cts.put(".iff", "application/x-iff");
		cts.put(".ig4", "application/x-g4");
		cts.put(".igs", "application/x-igs");
		cts.put(".iii", "application/x-iphone");
		cts.put(".img", "application/x-img");
		cts.put(".ins", "application/x-internet-signup");
		cts.put(".isp", "application/x-internet-signup");
		cts.put(".IVF", "video/x-ivf");
		cts.put(".java", "java/*");
		cts.put(".jfif", "image/jpeg");
		cts.put(".jpe", "image/jpeg");
		cts.put(".jpeg", "image/jpeg");
		cts.put(".jpg", "image/jpeg");
		cts.put(".js", "application/x-javascript");
		cts.put(".jsp", "text/html");
		cts.put(".la1", "audio/x-liquid-file");
		cts.put(".lar", "application/x-laplayer-reg");
		cts.put(".latex", "application/x-latex");
		cts.put(".lavs", "audio/x-liquid-secure");
		cts.put(".lbm", "application/x-lbm");
		cts.put(".lmsff", "audio/x-la-lms");
		cts.put(".ls", "application/x-javascript");
		cts.put(".ltr", "application/x-ltr");
		cts.put(".m1v", "video/x-mpeg");
		cts.put(".m2v", "video/x-mpeg");
		cts.put(".m3u", "audio/mpegurl");
		cts.put(".m4e", "video/mpeg4");
		cts.put(".mac", "application/x-mac");
		cts.put(".man", "application/x-troff-man");
		cts.put(".math", "text/xml");
		cts.put(".mdb", "application/msaccess");
		cts.put(".mfp", "application/x-shockwave-flash");
		cts.put(".mht", "message/rfc822");
		cts.put(".mhtml", "message/rfc822");
		cts.put(".mi", "application/x-mi");
		cts.put(".mid", "audio/mid");
		cts.put(".midi", "audio/mid");
		cts.put(".mil", "application/x-mil");
		cts.put(".mml", "text/xml");
		cts.put(".mnd", "audio/x-musicnet-download");
		cts.put(".mns", "audio/x-musicnet-stream");
		cts.put(".mocha", "application/x-javascript");
		cts.put(".movie", "video/x-sgi-movie");
		cts.put(".mp1", "audio/mp1");
		cts.put(".mp2", "audio/mp2");
		cts.put(".mp2v", "video/mpeg");
		cts.put(".mp3", "audio/mp3");
		cts.put(".mp4", "video/mpeg4");
		cts.put(".mpa", "video/x-mpg");
		cts.put(".mpd", "application/vnd.ms-project");
		cts.put(".mpe", "video/x-mpeg");
		cts.put(".mpeg", "video/mpg");
		cts.put(".mpg", "video/mpg");
		cts.put(".mpga", "audio/rn-mpeg");
		cts.put(".mpp", "application/vnd.ms-project");
		cts.put(".mps", "video/x-mpeg");
		cts.put(".mpt", "application/vnd.ms-project");
		cts.put(".mpv", "video/mpg");
		cts.put(".mpv2", "video/mpeg");
		cts.put(".mpw", "application/vnd.ms-project");
		cts.put(".mpx", "application/vnd.ms-project");
		cts.put(".mtx", "text/xml");
		cts.put(".mxp", "application/x-mmxp");
		cts.put(".net", "image/pnetvue");
		cts.put(".nrf", "application/x-nrf");
		cts.put(".nws", "message/rfc822");
		cts.put(".odc", "text/x-ms-odc");
		cts.put(".out", "application/x-out");
		cts.put(".p10", "application/pkcs10");
		cts.put(".p12", "application/x-pkcs12");
		cts.put(".p7b", "application/x-pkcs7-certificates");
		cts.put(".p7c", "application/pkcs7-mime");
		cts.put(".p7m", "application/pkcs7-mime");
		cts.put(".p7r", "application/x-pkcs7-certreqresp");
		cts.put(".p7s", "application/pkcs7-signature");
		cts.put(".pc5", "application/x-pc5");
		cts.put(".pci", "application/x-pci");
		cts.put(".pcl", "application/x-pcl");
		cts.put(".pcx", "application/x-pcx");
		cts.put(".pdf", "application/pdf");
		cts.put(".pdx", "application/vnd.adobe.pdx");
		cts.put(".pfx", "application/x-pkcs12");
		cts.put(".pgl", "application/x-pgl");
		cts.put(".pic", "application/x-pic");
		cts.put(".pko", "application/vnd.ms-pki.pko");
		cts.put(".pl", "application/x-perl");
		cts.put(".plg", "text/html");
		cts.put(".pls", "audio/scpls");
		cts.put(".plt", "application/x-plt");
		cts.put(".png", "image/png");
		cts.put(".pot", "application/vnd.ms-powerpoint");
		cts.put(".ppa", "application/vnd.ms-powerpoint");
		cts.put(".ppm", "application/x-ppm");
		cts.put(".pps", "application/vnd.ms-powerpoint");
		cts.put(".ppt", "application/vnd.ms-powerpoint");
		cts.put(".pr", "application/x-pr");
		cts.put(".prf", "application/pics-rules");
		cts.put(".prn", "application/x-prn");
		cts.put(".prt", "application/x-prt");
		cts.put(".ps", "application/postscript");
		cts.put(".ptn", "application/x-ptn");
		cts.put(".pwz", "application/vnd.ms-powerpoint");
		cts.put(".r3t", "text/vnd.rn-realtext3d");
		cts.put(".ra", "audio/vnd.rn-realaudio");
		cts.put(".ram", "audio/x-pn-realaudio");
		cts.put(".ras", "application/x-ras");
		cts.put(".rat", "application/rat-file");
		cts.put(".rdf", "text/xml");
		cts.put(".rec", "application/vnd.rn-recording");
		cts.put(".red", "application/x-red");
		cts.put(".rgb", "application/x-rgb");
		cts.put(".rjs", "application/vnd.rn-realsystem-rjs");
		cts.put(".rjt", "application/vnd.rn-realsystem-rjt");
		cts.put(".rlc", "application/x-rlc");
		cts.put(".rle", "application/x-rle");
		cts.put(".rm", "application/vnd.rn-realmedia");
		cts.put(".rmf", "application/vnd.adobe.rmf");
		cts.put(".rmi", "audio/mid");
		cts.put(".rmj", "application/vnd.rn-realsystem-rmj");
		cts.put(".rmm", "audio/x-pn-realaudio");
		cts.put(".rmp", "application/vnd.rn-rn_music_package");
		cts.put(".rms", "application/vnd.rn-realmedia-secure");
		cts.put(".rmvb", "application/vnd.rn-realmedia-vbr");
		cts.put(".rmx", "application/vnd.rn-realsystem-rmx");
		cts.put(".rnx", "application/vnd.rn-realplayer");
		cts.put(".rp", "image/vnd.rn-realpix");
		cts.put(".rpm", "audio/x-pn-realaudio-plugin");
		cts.put(".rsml", "application/vnd.rn-rsml");
		cts.put(".rt", "text/vnd.rn-realtext");
		cts.put(".rtf", "application/msword");
		cts.put(".rv", "video/vnd.rn-realvideo");
		cts.put(".sam", "application/x-sam");
		cts.put(".sat", "application/x-sat");
		cts.put(".sdp", "application/sdp");
		cts.put(".sdw", "application/x-sdw");
		cts.put(".sit", "application/x-stuffit");
		cts.put(".slb", "application/x-slb");
		cts.put(".sld", "application/x-sld");
		cts.put(".slk", "drawing/x-slk");
		cts.put(".smi", "application/smil");
		cts.put(".smil", "application/smil");
		cts.put(".smk", "application/x-smk");
		cts.put(".snd", "audio/basic");
		cts.put(".sol", "text/plain");
		cts.put(".sor", "text/plain");
		cts.put(".spc", "application/x-pkcs7-certificates");
		cts.put(".spl", "application/futuresplash");
		cts.put(".spp", "text/xml");
		cts.put(".ssm", "application/streamingmedia");
		cts.put(".sst", "application/vnd.ms-pki.certstore");
		cts.put(".stl", "application/vnd.ms-pki.stl");
		cts.put(".stm", "text/html");
		cts.put(".sty", "application/x-sty");
		cts.put(".svg", "text/xml");
		cts.put(".swf", "application/x-shockwave-flash");
		cts.put(".tdf", "application/x-tdf");
		cts.put(".tg4", "application/x-tg4");
		cts.put(".tga", "application/x-tga");
		cts.put(".tif", "image/tiff");
		cts.put(".tiff", "image/tiff");
		cts.put(".tld", "text/xml");
		cts.put(".top", "drawing/x-top");
		cts.put(".torrent", "application/x-bittorrent");
		cts.put(".tsd", "text/xml");
		cts.put(".txt", "text/plain");
		cts.put(".uin", "application/x-icq");
		cts.put(".uls", "text/iuls");
		cts.put(".vcf", "text/x-vcard");
		cts.put(".vda", "application/x-vda");
		cts.put(".vdx", "application/vnd.visio");
		cts.put(".vml", "text/xml");
		cts.put(".vpg", "application/x-vpeg005");
		cts.put(".vsd", "application/vnd.visio");
		cts.put(".vss", "application/vnd.visio");
		cts.put(".vst", "application/vnd.visio");
		cts.put(".vsw", "application/vnd.visio");
		cts.put(".vsx", "application/vnd.visio");
		cts.put(".vtx", "application/vnd.visio");
		cts.put(".vxml", "text/xml");
		cts.put(".wav", "audio/wav");
		cts.put(".wax", "audio/x-ms-wax");
		cts.put(".wb1", "application/x-wb1");
		cts.put(".wb2", "application/x-wb2");
		cts.put(".wb3", "application/x-wb3");
		cts.put(".wbmp", "image/vnd.wap.wbmp");
		cts.put(".wiz", "application/msword");
		cts.put(".wk3", "application/x-wk3");
		cts.put(".wk4", "application/x-wk4");
		cts.put(".wkq", "application/x-wkq");
		cts.put(".wks", "application/x-wks");
		cts.put(".wm", "video/x-ms-wm");
		cts.put(".wma", "audio/x-ms-wma");
		cts.put(".wmd", "application/x-ms-wmd");
		cts.put(".wmf", "application/x-wmf");
		cts.put(".wml", "text/vnd.wap.wml");
		cts.put(".wmv", "video/x-ms-wmv");
		cts.put(".wmx", "video/x-ms-wmx");
		cts.put(".wmz", "application/x-ms-wmz");
		cts.put(".wp6", "application/x-wp6");
		cts.put(".wpd", "application/x-wpd");
		cts.put(".wpg", "application/x-wpg");
		cts.put(".wpl", "application/vnd.ms-wpl");
		cts.put(".wq1", "application/x-wq1");
		cts.put(".wr1", "application/x-wr1");
		cts.put(".wri", "application/x-wri");
		cts.put(".wrk", "application/x-wrk");
		cts.put(".ws", "application/x-ws");
		cts.put(".ws2", "application/x-ws");
		cts.put(".wsc", "text/scriptlet");
		cts.put(".wsdl", "text/xml");
		cts.put(".wvx", "video/x-ms-wvx");
		cts.put(".x_b", "application/x-x_b");
		cts.put(".x_t", "application/x-x_t");
		cts.put(".xdp", "application/vnd.adobe.xdp");
		cts.put(".xdr", "text/xml");
		cts.put(".xfd", "application/vnd.adobe.xfd");
		cts.put(".xfdf", "application/vnd.adobe.xfdf");
		cts.put(".xhtml", "text/html");
		cts.put(".xls", "application/vnd.ms-excel");
		cts.put(".xlw", "application/x-xlw");
		cts.put(".xml", "text/xml");
		cts.put(".xpl", "audio/scpls");
		cts.put(".xq", "text/xml");
		cts.put(".xql", "text/xml");
		cts.put(".xquery", "text/xml");
		cts.put(".xsd", "text/xml");
		cts.put(".xsl", "text/xml");
		cts.put(".xslt", "text/xml");
		cts.put(".xwd", "application/x-xwd");

	}
}
