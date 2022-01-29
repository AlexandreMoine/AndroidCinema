package com.epul.androidcinema.presentation;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.epul.androidcinema.MainActivity;
import com.epul.androidcinema.domain.Movie;
import com.epul.androidcinema.R;
import com.epul.androidcinema.error.MonException;
import com.epul.androidcinema.service.RetrofitClientBearer;
import com.epul.androidcinema.service.ServiceMovie;
import com.epul.androidcinema.service.SessionManager;
import com.google.gson.JsonSyntaxException;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ActivityMovie extends AppCompatActivity implements View.OnClickListener  {

    private static final String DEFAULT_QUERY = "Android";
    private static final String TAG = "Main Activity";
    private static final String NO_ERROR_VALUE = "0";
    private Button btRetour;
    private String auth;

    private List<Movie> movies = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        btRetour = (Button) findViewById(R.id.btRetour);
        btRetour.setOnClickListener(this);
        loadMovies();
    }

    public void onClick(View v) {
        String information = "";
        if (v == btRetour) {
            try {
                Intent intent = new Intent(this, MainActivity.class);
                this.finish();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onStart() {

        String information = "";
        super.onStart();
    }

    public void loadMovies() {

        SessionManager uneSession = new SessionManager(this);
        String unToken = uneSession.fetchAuthToken();
        String autho = "Bearer " + unToken;
        try {
            Retrofit retrofit = RetrofitClientBearer.getClientRetrofit(this);
            // On crée un adapteur rest sur l'url
            ServiceMovie unMovieService = retrofit.create(ServiceMovie.class);

            // On appelle la méthode qui retourne les frais
            Call<List<Movie>> call = unMovieService.getMovies();

            // appel asynchrone
            call.enqueue(new Callback<List<Movie>>() {

                @Override
                public void onResponse(Call<List<Movie>> call, Response<List<Movie>> uneReponse) {
                    if (uneReponse.isSuccessful()) {
                        //Recupérer le corps de la reponse que Retrofit s'est chargé de désérialiser à notre place l'aide du convertor Gson
                        if (uneReponse.body() != null) {
                            movies = uneReponse.body();
                            System.out.println("movies = " + movies);
                            affiche(movies);
                        } else {
                            Toast.makeText(ActivityMovie.this, "Erreur d'appel!", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        //Toast.makeText(MainActivity.this, "Erreur rencontrée", Toast.LENGTH_LONG).show();
                        Log.d(TAG, "onResponse =>>> code = " + uneReponse.code());
                    }
                }

                @Override
                public void onFailure(Call<List<Movie>> call, Throwable t) {
                    System.out.println("fail");
                    t.printStackTrace();
                    call.cancel();
                }
            });
        } catch (IllegalStateException | JsonSyntaxException exception) {
            new MonException(exception.getMessage(), "Erreur Appel WS Connexion");
        } catch (Exception e) {
            new MonException(e.getMessage(), "Erreur Appel WS Connexion");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0)
            auth = (String) data.getExtras().get("auth");
    }

    protected void affiche(List<Movie> result) {

        ListView listViewData = (ListView) findViewById(R.id.lvClient);
        String data = "";
        TextView txtMessage = (TextView) findViewById(R.id.txMessage);
        String Error = null;
        movies = result;

        if (Error != null) {
            txtMessage.setText("Output : " + Error);
        } else {

            // On visualise la réponse sur l'écran (activity)
            txtMessage.setText("Voici le résultat");
            if (result != null) {
                listViewData.clearAnimation();
                LayoutInflater inflater = getLayoutInflater();
                ViewGroup header = (ViewGroup) inflater.inflate(R.layout.header, listViewData, false);
                if (listViewData.getHeaderViewsCount() == 0)
                    listViewData.addHeaderView(header, null, false);
                final ObjetAdapter adapter = new ObjetAdapter(ActivityMovie.this, android.R.layout.simple_list_item_1, movies);
                listViewData.setAdapter(adapter);
                listViewData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Movie movie = movies.get(position - 1); // on récupère l'objet selectionné
                        // action
                        //Intent intent = new Intent(ActivityAfficheClient.this, ActivityModifSup.class);
                        //intent.putExtra("unClient", unClient);
                        //startActivityForResult(intent, 1);
                    }
                });
            }

        }
    }


}
