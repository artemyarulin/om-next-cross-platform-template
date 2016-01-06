(ns leiningen.new.om-next-cross-platform
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]
            [clojure.string :refer [capitalize]]))

(def render (renderer "om-next-cross-platform"))

(defn om-next-cross-platform [name]
  (let [data {:name name
              :sanitized (name-to-path name)
              :app-name (str (capitalize name) "App")}]
    (main/info "Generating fresh 'lein new' om-next-cross-platform project.")
    (->files data
             ["README.md" (render "README.md" data)]
             ["project.clj" (render "project.clj" data)]
             ["src/{{name}}/core.cljs" (render "core.cljs" data)]
             ["src/{{name}}/state.cljs" (render "state.cljs" data)]
             ["src/react/dom.cljs" (render "dom.cljs" data)]
             ["src/react/react.cljs" (render "react.cljs" data)]
             ["src/repl/repl.cljs" (render "repl.cljs" data)]
             ["resources/public/index.html" (render "index.html" data)])))
