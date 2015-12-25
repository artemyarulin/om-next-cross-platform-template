(ns {{name}}.core
  (:require [om.next :as om :refer-macros [defui]]
            [om.dom :as dom]
            [ktoa.core :as ktoa :refer [view text text-input]]))

(def status "Hello cross-platform world!")

(defn render-mobile []
  (view nil
        (text nil "Mobile:")
        (text nil status)))

(defn render-browser []
  (dom/div nil
           (dom/div nil "Browser:")
           (dom/div nil status)))

(defui RootComponent
  Object
  (render [this]
          (if ktoa/react-native?
            (render-mobile)
            (render-browser))))

(ktoa/register! "RootViewRN"
                #(om/add-root! (om/reconciler ktoa/om-options)
                               RootComponent
                               %)
                #(.querySelector js/document "#app"))
