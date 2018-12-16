(defproject clojure-todo-list "0.1.0-SNAPSHOT"
  :description "A Todo List server-side webapp using Ring & Compojure"
  :url "https://github.com/biezhi/clojure-todo-list"
  :license {:name "MIT License"
            :url "https://opensource.org/licenses/MIT"}
  :repl-options {:init-ns todo-list.core}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [ring "1.7.1"]
                 [ring/ring-jetty-adapter "1.7.1"]
                 [compojure "1.6.1"]]

  :main todo-list.core
  :min-lein-version "2.8.3"
  :uberjar-name "todo-list.jar"
  :profiles {:dev {:main todo-list.core/-dev-main}})
