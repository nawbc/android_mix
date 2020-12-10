// package com.sewerganger.android_mix;

// import android.app.Activity;
// import android.content.Context;
// import android.net.ConnectivityManager;
// import android.net.Network;
// import android.net.NetworkCapabilities;
// import android.net.NetworkInfo;
// import android.net.wifi.WifiInfo;
// import android.net.wifi.WifiManager;
// import android.os.Build;

// import java.net.Inet4Address;
// import java.net.InetAddress;
// import java.net.NetworkInterface;
// import java.net.SocketException;
// import java.util.Enumeration;

// import io.flutter.Log;

// class WiFi {
//   private Context context;
//   private Activity activity;
//   private WifiManager wifiManager;

//   @Override
//   protected void finalize() throws Throwable {
//     super.finalize();
//     activity = null;
//     wifiManager = null;
//     context = null;
//   }

//   public WiFi(Context c, Activity a) {
//     context = c;
//     activity = a;
//     wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
//   }


//   private static String intIP2StringIP(int ip) {
//     return (ip & 0xFF) + "." +
//       ((ip >> 8) & 0xFF) + "." +
//       ((ip >> 16) & 0xFF) + "." +
//       (ip >> 24 & 0xFF);
//   }

//   public boolean isConnected() {
//     NetworkInfo info = ((ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
//     if (info != null && info.isConnected()) {
//       return true;
//     } else {
//       return false;
//     }
//   }

//   public String getIp() throws Exception {
//     ConnectivityManager cm = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
//     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//       Network network = cm.getActiveNetwork();
//       if (network != null) {
//         NetworkCapabilities capabilities = cm.getNetworkCapabilities(network);
//         Log.d("DEMO", capabilities.toString());
//         if (capabilities != null) {
//           if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
//             Log.d("demo1",  "==========================");
//             for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
//               NetworkInterface intf = en.nextElement();
//               for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
//                 InetAddress inetAddress = enumIpAddr.nextElement();
//                 if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
//                   return inetAddress.getHostAddress();
//                 }
//               }
//             }
//           }

//           if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
//             Log.d("demo2",  "==========================");
//             WifiInfo wifiInfo = wifiManager.getConnectionInfo();
//             return intIP2StringIP(wifiInfo.getIpAddress());
//           }
//         }
//       }
//     } else {
//       NetworkInfo info = ((ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
//       Log.d("DEMO1", "===============================");
//       if (info != null) {
//         if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
//           Log.d("DEMO321321", "=============@==========@@@@========");
//           try {
//             for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
//               NetworkInterface intf = en.nextElement();
//               for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
//                 InetAddress inetAddress = enumIpAddr.nextElement();
//                 if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
//                   return inetAddress.getHostAddress();
//                 }
//               }
//             }
//           } catch (SocketException e) {
//             throw e;
//           }
//         } else if (info.getType() == ConnectivityManager.TYPE_WIFI) {
//           Log.d("D1312313121", "=============@==========@@@@========");
//           WifiInfo wifiInfo = wifiManager.getConnectionInfo();
//           return intIP2StringIP(wifiInfo.getIpAddress());
//         }
//       }
//     }
//     return null;
//   }
// }
