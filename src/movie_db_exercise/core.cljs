(ns movie-db-exercise.core
  (:require
   [reagent.core :as r]
   [reagent.dom :as d]
   [movie-db-exercise.components.search :as search]
   [movie-db-exercise.components.results :as results]))

;; -------------------------
;; Views

(defn home-page []
  [:div {:class "outer-container"
         :style {:display :flex
                 :flex-direction :column
                 :justify-content (when (false? @search/loaded?) :center)
                 :align-items :center
                 :height "100vh"}}
   (search/box)
   (results/box)])

;; -------------------------
;; Initialize app

(defn mount-root []
  (d/render [home-page] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))
