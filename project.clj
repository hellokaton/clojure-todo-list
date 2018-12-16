(defproject clojure-todo-list "0.1.0-SNAPSHOT"
  :description "A Todo List server-side webapp using Ring & Compojure"
  :url "https://github.com/biezhi/clojure-todo-list"
  :license {:name "MIT License"
            :url "https://opensource.org/licenses/MIT"}
  :repl-options {:init-ns todo-list.core}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [ring/ring-core "1.7.1"]
                 [ring/ring-jetty-adapter "1.7.1"]]
  :main todo-list.core)
