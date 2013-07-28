package bot.settings;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Downloader {
	
	public static void download(String url, String saveTo)
			throws MalformedURLException, IOException {

		final HttpURLConnection con = (HttpURLConnection) new URL(url)
				.openConnection();

		final InputStream is = con.getInputStream();

		try {
			final FileOutputStream fos = new FileOutputStream(saveTo);
			final byte[] data = new byte[1024];
			int len;
			try {
				while ((len = is.read(data, 0, data.length)) != -1) {
					fos.write(data, 0, len);
				}
			} finally {
				fos.close();
			}
		} finally {
			is.close();
		}

	}
	
}
