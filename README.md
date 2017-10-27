# AndroidDev-Cek_Koneksi_Internet
Berikut adalah tutorial bagaimana aplikasi kita akan mengecek koneksi internet terlebih dahulu sebelum berinteraksi dengan server. di dalam tutorial ini interaksi yang dicontohkan adalah mengambil data wisata dari server.

Pertama buat file koneksi, saya buat file tersebut dengan nama Connection hingga akhirnya menjadi file java yaitu Connection.java.
Di dalam file tersebut terdapat method Connection yang isinya adalah fungsi untuk memanggil service koneksi baik itu dengan koneksi internet dengan wifi ataupun data selular.

Kedua, setelah membuat file koneksi tersebut. lalu kita akan implementasi pada sebuah file java yang didalamnya terdapat sebuah activity yang akan berinteraksi dengan sebuah server menggunakan koneksi internet. file tersebut saya beri nama DaftarWisata_ImplementasiCekKoneksi. Di dalam file tersebut tepatnya pada method load_data_from_server terdapat override methods yaitu doInBackground yang isinya terdapat fungsi untuk memanggil method Connection dari file koneksi yang tadi sudah kita buat.

Ketiga, penggunaan methodnya sangat simple, kita hanya perlu menuliskan (NamaFile)(dot)method-nya. contohnya di dalam override method tsb saya tinggal panggil saja "Connection.isInternetConnected" untuk memanggil fungsi cek koneksi internet dari file Connection yang dibuat sebelumnya. Oh IYA PERLU DIINGAT yaaa, di dalam override methods doInBackground tersebut saya melakukan fungsi sesuai kasus yang saya kerjakan jadi kalian tinggal modif-modif aja sesuai kasus kalian. jadi intinya untuk cek koneksi internet tinggal panggil saja method di dalam file Connection-nya OKE!!!!

OH IYA, Kalo ada yang tanya saya pakai apa untuk bisa terhubung / interaksi android dengan server, saya itu pakai Custom Volley. untuk tutorialnya nanti saya buat ya hehe.

SALAM CODINGERS!
