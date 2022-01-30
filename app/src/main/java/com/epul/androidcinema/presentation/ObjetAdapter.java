package com.epul.androidcinema.presentation;

import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.epul.androidcinema.R;
import com.epul.androidcinema.domain.Category;
import com.epul.androidcinema.domain.Movie;

import java.util.List;

public class ObjetAdapter extends ArrayAdapter<Movie> {

    private List<Movie> movies;

    private LayoutInflater layoutInflater;
    private Context context;

    public ObjetAdapter(Context context, int textViewResourceId, List<Movie> movies) {
        super(context, textViewResourceId, movies);
        // On recopie la collection
        this.movies = movies;

        layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the current list item
        final Movie item = movies.get(position);
        // Get the layout for the list item
        final LinearLayout itemLayout = (LinearLayout)
                LayoutInflater.from(context).inflate(R.layout.header, parent, false);
        // Set the text label as defined in our list item

        TextView txtmovieId = (TextView) itemLayout.findViewById(R.id.txtmovieId);
        txtmovieId.setText(String.valueOf(item.getId())+ "   ");

        TextView txtmovieTitle = (TextView) itemLayout.findViewById(R.id.txtmovieTitle);
        txtmovieTitle.setText(item.getTitle()+ "   ");

        TextView txtmovieDuration = (TextView) itemLayout.findViewById(R.id.txtmovieDuration);
        txtmovieDuration.setText(item.getDuration()+ "   ");

        TextView txtmovieReleaseDate = (TextView) itemLayout.findViewById(R.id.txtmovieReleaseDate);
        txtmovieReleaseDate.setText(item.getReleaseDate()+ "   ");

        //TextView txtmovieBudget = (TextView) itemLayout.findViewById(R.id.txtmovieBudget);
        //txtmovieBudget.setText(item.getBudget()+ "   ");

        //TextView txtmovieRevenueAmount = (TextView) itemLayout.findViewById(R.id.txtmovieRevenueAmount);
        //txtmovieRevenueAmount.setText(item.getRevenue_amount()+ "   ");

        TextView txtCategory = (TextView) itemLayout.findViewById(R.id.txtCategory);
        if(item.getCategories().isEmpty()) {
            txtCategory.setText("");
        } else {
            String txtC = "";
            for(Category c : item.getCategories()) {
                txtC += c.getName() + "-";
            }
            txtC = txtC.substring(0, txtC.length() - 1);
            txtCategory.setText(txtC);
        }

        TextView txtDirector = (TextView) itemLayout.findViewById(R.id.txtDirector);
        if(item.getDirector() != null)
            txtDirector.setText(item.getDirector().getFirstname() + " " + item.getDirector().getLastname());
        else
            txtDirector.setText("");

        return itemLayout;
    }

}
