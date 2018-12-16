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

(defn about
  "这是关于页面"
  [request]
  {:status 200
   :body "我是一个写代码的，只有我享受这无聊的事！"
   :headers {}})

(defn request-info
  "查看请求中包含的信息，对调试很有用"
  [request]
  {:status 200
   :body (pr-str request)
   :headers {}})

(defroutes app
  (GET "/" [] welcome)
  (GET "/about" [] about)
  (GET "/request-info" [] request-info)
  (not-found "<h1>没有找到你要请求的资源</h1>
              <p>这是一篇无人知晓的荒地！</p>"))

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