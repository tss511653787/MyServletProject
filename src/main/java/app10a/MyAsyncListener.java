package app10a;

import java.io.IOException;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;

public class MyAsyncListener implements AsyncListener {

	@Override
	public void onComplete(AsyncEvent asyncEvent) throws IOException {
		System.out.println("onComplete");
	}

	@Override
	public void onError(AsyncEvent asyncEvent) throws IOException {
		System.out.println("onError");
	}

	@Override
	public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
		System.out.println("onStartAsync");
	}

	@Override
	public void onTimeout(AsyncEvent asyncEvent) throws IOException {
		System.out.println("onTimeout");
	}

}
