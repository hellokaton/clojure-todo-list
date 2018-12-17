(ns todo-list.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]
            [todo-list.routes.routes :refer [app]]))

;(def app
;  (routes #'play-routes #'base-routes #'task-routes))

(defn -main
  "一个 Ring 的 Hello World 程序"
  [port]
  (jetty/run-jetty app {:port (Integer. port)}))

(defn -dev-main
  "开发环境热加载可还行"
  [port]
  (jetty/run-jetty (wrap-reload #'app) {:port (Integer. port)}))