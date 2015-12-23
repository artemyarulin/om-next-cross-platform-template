(ns leiningen.new.om-next-cross-platform
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "om-next-cross-platform"))

(defn om-next-cross-platform
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' om-next-cross-platform project.")
    (->files data
             ["src/{{sanitized}}/foo.clj" (render "foo.clj" data)])))
