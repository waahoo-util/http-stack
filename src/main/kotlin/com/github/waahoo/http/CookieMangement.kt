package com.github.waahoo.http

import com.github.waahoo.bilibili.util.PersistentCookieStore
import java.net.CookieHandler
import java.net.CookieManager
import java.net.CookiePolicy

object CookieMangement {
  var cookieMgr = CookieManager(PersistentCookieStore, CookiePolicy.ACCEPT_ALL)
  
  init {
    CookieHandler.setDefault(cookieMgr)
  }
}

