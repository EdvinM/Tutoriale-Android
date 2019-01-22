package ro.ramonnastase.tutorialeandroid;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

import ro.ramonnastase.tutorialeandroid.Helpers.HttpHandler;

public class SendRequestAsync extends AsyncTask<Void, Void, String> {

    private TextView textViewResponse;
    private ProgressBar progressBarLoading;

    public SendRequestAsync(TextView textViewResponse, ProgressBar progressBarLoading) {
        this.textViewResponse = textViewResponse;
        this.progressBarLoading = progressBarLoading;
    }

    @Override
    public void onPreExecute() {
        progressBarLoading.setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    protected String doInBackground(Void... voids) {
        HttpHandler httpHandler = new HttpHandler("https://jsonplaceholder.typicode.com/posts/1", HttpHandler.Type.GET);

        return httpHandler.makeServiceCall();
    }

    @Override
    protected void onPostExecute(String response) {
        progressBarLoading.setVisibility(ProgressBar.GONE);

        this.textViewResponse.setText(response);
    }
}
