(ns {{name}}.state
    (:require [ktoa.state :as ktoa :refer-macros [persist]]))

(defonce app-state (atom {:msg "Hello cross-platform world!"}))

(persist app-state)
