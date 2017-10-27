private void load_data_from_server(int id) {
        AsyncTask<Integer,Void,Void> task = new AsyncTask<Integer, Void, Void>() {

            @Override
            protected void onPreExecute() {
                rv_progress.setVisibility(View.VISIBLE);
            }

            @Override
            protected Void doInBackground(Integer... integers) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(Config.DATA_URL+integers[0])
                        .build();
                try {
                    if ((!Connection.isInternetConnected(ListWisataActivity.this) && retrievedString!=null) ||
                            (Connection.isInternetConnected(ListWisataActivity.this) && retrievedString!=null)){
                        array = new JSONArray(retrievedString);
                    }else if ((Connection.isInternetConnected(ListWisataActivity.this) && retrievedString==null)){
                        Response response = client.newCall(request).execute();
                        array = new JSONArray(response.body().string());
                    }else if ((!Connection.isInternetConnected(ListWisataActivity.this) && retrievedString==null)){
                        array = new JSONArray("");
                    }
                    for (int i=0; i<array.length(); i++){
                        JSONObject object = array.getJSONObject(i);
                        jsonString = array.toString();
                        Wisata data = new Wisata(object.getInt("id_wisata"),object.getString("nama_wisata"),
                                object.getString("alamat"),object.getDouble("rating_wisata"),object.getString("photo_wisata")
                                ,object.getDouble("lat"),object.getDouble("lng"));
                        data_list.add(data);

                        sharedPref = getSharedPreferences("KEY_JSONW", Context.MODE_PRIVATE);
                        editor = sharedPref.edit();
                        editor.putString("jsonW", jsonString);
                        editor.commit();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    System.out.println("End of content");
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                adapter.notifyDataSetChanged();
                rv_progress.setVisibility(View.GONE);
            }
        };

        task.execute(id);
    }