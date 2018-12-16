(ns todo-list.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]
            [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [not-found]]
            [ring.handler.dump :refer [handle-dump]]))

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

(defn hello
  "一个 restful 风格的路由"
  [request]
  (let [name (get-in request [:route-params :name])]
    {:status 200
     :body (str "你好 " name "，你终于访问这个 URL 了！")
     :headers {"Content-Type" "text/html;charset=UTF-8"}}))

(defroutes app
  (GET "/" [] welcome)
  (GET "/about" [] about)
  (GET "/hello/:name" [] hello)
  (GET "/request-info" [] handle-dump)
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