(ns repl.repl
  (:require [ktoa.repl :refer [start-repl]]))

(start-repl {:app-name "RootViewRN"
             :base-url "http://localhost:3449/js"
             :root-ns  "app.core"})
