(ns todo-list.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]))

(defn welcome
  "这是欢迎页"
  [request]
  (if (= "/" (:uri request))
    {:status 200
     :body "<h1>你好，这是欢迎页面！</h1>"
     :headers {"Content-Type" "text/html;charset=UTF-8"}}

    {:status 404
     :body (str "<h1>很抱歉，找不到你要请求的资源！</h1> url:" (:uri request))
     :headers {"Content-Type" "text/html;charset=UTF-8"}}))

(defn -main
  "一个 Ring 的 Hello World 程序"
  [port]
  (jetty/run-jetty welcome
    {:port (Integer. port)}))

(defn -dev-main
  "一个 Ring 的 Hello World 程序"
  [port]
  (jetty/run-jetty (wrap-reload #'welcome)
                   {:port (Integer. port)}))