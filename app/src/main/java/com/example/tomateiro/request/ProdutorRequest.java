package com.example.tomateiro.request;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tomateiro.model.Produtor;
import com.example.tomateiro.model.Safra;
import com.example.tomateiro.model.Url;
import com.example.tomateiro.view.LoginActivity;
import com.example.tomateiro.view.PainelActivity;
import com.example.tomateiro.view.RecuperarActivity;
import com.example.tomateiro.view.RegistroActivity;
import com.example.tomateiro.view.RelatorioActivity;
import com.google.gson.Gson;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static com.example.tomateiro.model.CustonToast.viewToast;
import static com.example.tomateiro.model.CustonToast.viewToastErro;

public class ProdutorRequest {
    private RequestQueue mRequestQueue;
    private Context context;
    private List<Produtor> produtorList = new ArrayList<>();
    private Url url = new Url();
    private String ip = url.getUrl();

    private Produtor produtor = new Produtor();

    public ProdutorRequest(Context context) {
        this.context = context;
        mRequestQueue = Volley.newRequestQueue(context);
    }

    public void cadastrar_produtor(final String json, final RegistroActivity activity) {

        String url = ip + "/produtor/";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    produtor = new Gson().fromJson(jsonObject.toString(), Produtor.class);
                    activity.cadastro_request(produtor);
                    viewToast(context, "Registro concluido com sucesso!");

                } catch (Exception e) {
                    e.printStackTrace();
                    viewToastErro(context, "Ops! Algo deu errado");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
                viewToastErro(context, "Ops! Algo deu errado");
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    return json == null ? null : json.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {
                    viewToastErro(context, "Ops! Algo deu errado");
                    return null;

                }

            }

        };

        mRequestQueue.add(stringRequest);

    }

    public List<Produtor> bsucar_todos() {

        String url = ip + "/produtor/todos";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        try {

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject produtors = jsonArray.getJSONObject(i);

                                produtor = new Gson().fromJson(produtors.toString(), Produtor.class);
                                produtorList.add(produtor);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        });
        mRequestQueue.add(request);
        return produtorList;
    }


    public void alterrar_produtor(final String json, Long id, final PainelActivity activity) {

        String url = ip + "/produtor/" + id;

        StringRequest stringRequest = new StringRequest(Request.Method.PUT, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    produtor = new Gson().fromJson(jsonObject.toString(), Produtor.class);
                    activity.request_alterar_dados_produtor(produtor);
                    viewToast(context, "Dados alterados!");
                } catch (Exception e) {
                    e.printStackTrace();
                    viewToastErro(context, "Ops! Algo deu errado");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                viewToastErro(context, "Ops! Algo deu errado");
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    return json == null ? null : json.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {
                    viewToastErro(context, "Ops! Algo deu errado");
                    return null;
                }
            }
        };

        mRequestQueue.add(stringRequest);
    }

    public void login(final String json, final LoginActivity activity) {

        String url = ip + "/produtor/login/";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    produtor = new Gson().fromJson(jsonObject.toString(), Produtor.class);
                    activity.login_request(produtor);

                } catch (Exception e) {
                    e.printStackTrace();
                    viewToastErro(context, "Ops! Algo deu errado");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
                viewToastErro(context, "Ops! Algo deu errado");
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    return json == null ? null : json.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {
                    viewToastErro(context, "Ops! Algo deu errado");
                    return null;

                }

            }

        };

        mRequestQueue.add(stringRequest);

    }

    public void recuperar_senha(Long cod, String email, final RecuperarActivity activity) {

        String url = ip + "/sendemail/" + cod + "/" + email;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                activity.request();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        });
        mRequestQueue.add(stringRequest);
    }
}