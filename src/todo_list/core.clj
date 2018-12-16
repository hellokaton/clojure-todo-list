(ns todo-list.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]
            [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [not-found]]))

(defn welcome
  "这是欢迎页"
  [request]
    {:status 200
     :body "<h1>你好，这是欢迎页面！</h1>"
     :headers {"Content-Type" "text/html;charset=UTF-8"}})

(defroutes app
  (GET "/" [] welcome)
  (not-found "<h1>This is not the page you are looking for</h1>
              <p>Sorry, the page you requested was not found!</p>"))

(defn -main
  "一个 Ring 的 Hello World 程序"
  [port]
  (jetty/run-jetty app
    {:port (Integer. port)}))

(defn -dev-main
  "开发环境热加载可还行"
  [port]
  (jetty/run-jetty (wrap-reload #'app)
                   {:port (Integer. port)}))