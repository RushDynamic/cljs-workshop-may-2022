(ns movie-db-exercise.components.results
  (:require
   [movie-db-exercise.components.search :as search]))

(defn box []
  (when @search/loaded?
    [:div {:style
           {:display :flex
            :flex-direction :column
            :align-items :center}}
     [:h2 (:Title @search/data)]
     [:img {:src (:Poster @search/data)
            :width "300px"}]
     [:p (:Plot @search/data)]]))