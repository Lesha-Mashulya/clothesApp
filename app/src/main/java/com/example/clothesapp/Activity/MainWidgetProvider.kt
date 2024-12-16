package com.example.clothesapp.Widget

import ScanQRCodeActivity
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.RemoteViews
import com.example.clothesapp.Activity.CartActivity
import com.example.clothesapp.Activity.MainActivity
import com.example.clothesapp.R

class MainWidgetProvider : AppWidgetProvider() {

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        for (appWidgetId in appWidgetIds) {
            val views = RemoteViews(context.packageName, R.layout.widget_main)


            val cartIntent = Intent(context, CartActivity::class.java)
            val cartPendingIntent = PendingIntent.getActivity(context, 0, cartIntent, PendingIntent.FLAG_IMMUTABLE)
            views.setOnClickPendingIntent(R.id.widget_cart_button, cartPendingIntent)


            val popularIntent = Intent(context, MainActivity::class.java)
            val popularPendingIntent = PendingIntent.getActivity(context, 1, popularIntent, PendingIntent.FLAG_IMMUTABLE)
            views.setOnClickPendingIntent(R.id.widget_popular_button, popularPendingIntent)


            val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Google+Plex+Mountain+View+CA"))
            mapIntent.setPackage("com.google.android.apps.maps")
            val mapPendingIntent = PendingIntent.getActivity(context, 2, mapIntent, PendingIntent.FLAG_IMMUTABLE)
            views.setOnClickPendingIntent(R.id.widget_map_button, mapPendingIntent)


            val balanceIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://lime-shop.digift.ru"))
            val balancePendingIntent = PendingIntent.getActivity(context, 3, balanceIntent, PendingIntent.FLAG_IMMUTABLE)
            views.setOnClickPendingIntent(R.id.widget_balance_button, balancePendingIntent)

            val scanQrIntent = Intent(context, ScanQRCodeActivity::class.java) // Активность для сканирования QR-кода
            val scanQrPendingIntent = PendingIntent.getActivity(context, 4, scanQrIntent, PendingIntent.FLAG_IMMUTABLE)
            views.setOnClickPendingIntent(R.id.widget_scan_qr_button, scanQrPendingIntent)

            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }
}