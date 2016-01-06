(ns {{name}}.core
  (:require [om.next :as om :refer-macros [defui]]
            [om.dom :as dom]
            [ktoa.components :refer [view text]]
            [ktoa.core :as ktoa]
            [ktoa.om :as ktoa-om]
            [{{name}}.state :refer [app-state]]))

(defn render-mobile []
  (view nil
        (text nil "Mobile:")
        (text nil (:msg app-state))))

(defn render-browser []
  (dom/div nil
           (dom/div nil "Browser:")
           (dom/div nil (:msg app-state))))

(defui RootComponent
  Object
  (render [this]
          (if ktoa/react-native
            (render-mobile)
            (render-browser))))

(ktoa/register! "RootViewRN"
                #(om/add-root! (om/reconciler ktoa-om/om-options)
                               RootComponent
                               %)
                #(.querySelector js/document "#app"))
