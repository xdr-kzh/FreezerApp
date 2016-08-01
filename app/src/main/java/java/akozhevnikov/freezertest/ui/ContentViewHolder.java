package java.akozhevnikov.freezertest.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.akozhevnikov.freezertest.R;

/**
 * Created by alejandro on 28.07.16.
 */

public class ContentViewHolder extends RecyclerView.ViewHolder {
	public ImageView content;
	public TextView title;
	public TextView dateCreated;
	public TextView author;

	public ContentViewHolder(View itemView) {
		super(itemView);
		content = (ImageView) itemView.findViewById(R.id.content);
		title = (TextView) itemView.findViewById(R.id.title);
		dateCreated = (TextView) itemView.findViewById(R.id.date_created);
		author = (TextView) itemView.findViewById(R.id.author);
	}
}
