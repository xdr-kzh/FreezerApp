package java.akozhevnikov.freezertest.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import java.akozhevnikov.freezertest.CreateContent;
import java.akozhevnikov.freezertest.R;
import java.akozhevnikov.freezertest.model.Content;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {
	private ContentAdapter adapter;
	private RecyclerView recyclerView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);


		CreateContent content = new CreateContent();

		recyclerView = (RecyclerView) findViewById(R.id.list);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));

		content.call().subscribe(new Action1<List<Content>>() {
			@Override
			public void call(List<Content> contents) {

				adapter = new ContentAdapter(contents);
				recyclerView.setAdapter(adapter);
			}
		});
	}

	private class ContentAdapter extends RecyclerView.Adapter<ContentViewHolder> {
		private List<Content> contents;
		private SimpleDateFormat dateFormat;


		public ContentAdapter(List<Content> contents) {
			this.contents = contents;
			dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		}

		@Override
		public ContentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			View view = LayoutInflater.from(parent.getContext())
					.inflate(R.layout.content_item, parent, false);
			return new ContentViewHolder(view);
		}

		@Override
		public void onBindViewHolder(final ContentViewHolder holder, int position) {
			Content item = contents.get(position);

			Date date = new Date(item.dateCreated);

			holder.dateCreated.setText(dateFormat.format(date.getDate()));
			holder.title.setText(String.valueOf(item.title));
			Glide.with(MainActivity.this)
					.load(item.link)
					.into(holder.content);
			holder.author.setText(item.creator.nick);
		}

		@Override
		public int getItemCount() {
			return contents == null ? 0 : contents.size();
		}
	}
}
