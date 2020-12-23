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
import com.example.tomateiro.model.CustoA;
import com.example.tomateiro.model.Safra;
import com.example.tomateiro.model.Url;
import com.example.tomateiro.view.PainelActivity;
import com.example.tomateiro.view.RegistroActivity;
import com.example.tomateiro.view.VendaActivity;
import com.example.tomateiro.view.adapter.VendaAdapter;
import com.example.tomateiro.view.custo.CustoA_Activity;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static com.example.tomateiro.model.CustonToast.viewToast;
import static com.example.tomateiro.model.CustonToast.viewToastErro;

public class SafraRequest {
    private RequestQueue mRequestQueue;
    private Context context;
    private List<Safra> safraList = new ArrayList<>();
    private Url url = new Url();
    private String ip = url.getUrl();

    private Safra safra = new Safra();

    public SafraRequest(Context context) {
        this.context = context;
        mRequestQueue = Volley.newRequestQueue(context);
    }

    public void cadastrar_safra(final String json, final PainelActivity activity) {

        String url = ip + "/safra/";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    safra = new Gson().fromJson(jsonObject.toString(), Safra.class);
                    activity.request_cadastrar_novaSafra(safra);
                    viewToast(context, "Safra cadastrada com sucesso!");

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

    public List<Safra> bsucar_todos() {

        String url = ip + "/safra/todos";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        try {

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject safras = jsonArray.getJSONObject(i);

                                safra = new Gson().fromJson(safras.toString(), Safra.class);
                                safraList.add(safra);

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
        return safraList;
    }


    public void alterrar_safra(final String json, Long id, final PainelActivity activity) {

        String url = ip + "/safra/" + id;

        StringRequest stringRequest = new StringRequest(Request.Method.PUT, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    safra = new Gson().fromJson(jsonObject.toString(), Safra.class);
                    activity.request_alterar_safra(safra);
                    viewToast(context, "Safra alterada com sucesso!");

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

    public void alterrar_safra(final String json, Long id, final VendaActivity activity, final String acao) {

        String url = ip + "/safra/" + id;

        StringRequest stringRequest = new StringRequest(Request.Method.PUT, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    safra = new Gson().fromJson(jsonObject.toString(), Safra.class);
                    activity.request_cadastrarVenda(safra);

                    if (acao.equals("Desativar")) {
                        viewToast(context, "Venda apagada!");
                    }
                    if (acao.equals("Cadastrar")) {
                        viewToast(context, "Venda cadastrada!");
                    }
                    if (acao.equals("Alterar")) {
                        viewToast(context, "Venda alterada!");
                    }

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

    public void alterrar_safra(final String json, Long id, final VendaAdapter activity) {

        String url = ip + "/safra/" + id;

        StringRequest stringRequest = new StringRequest(Request.Method.PUT, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    safra = new Gson().fromJson(jsonObject.toString(), Safra.class);
                    activity.request_alterarDados(safra);


                    viewToast(context, "Venda alterada!");


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

    public void alterrar_safra(final String json, Long id, final CustoA_Activity activity) {

        String url = ip + "/safra/" + id;

        StringRequest stringRequest = new StringRequest(Request.Method.PUT, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    safra = new Gson().fromJson(jsonObject.toString(), Safra.class);
                    activity.request_cadastrar_custo(safra);


                    viewToast(context, "Custo calculado!!");


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

    public void buscar_safra_produtor(Long id, final PainelActivity activity) {

        String url = ip + "/safra/buscarSafraAtiva/"+id;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    safra = new Gson().fromJson(jsonObject.toString(), Safra.class);
                    activity.request_buscar_safra(safra);

                } catch (Exception e) {
                    e.printStackTrace();
                    viewToastErro(context, "Ops! Algo deu errado");
                }
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