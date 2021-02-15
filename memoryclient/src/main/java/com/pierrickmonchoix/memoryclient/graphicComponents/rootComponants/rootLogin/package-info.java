/**
 * Ce package regroupe les composant graphiques racines (root), ce qui seront affichés par le main.
 * Ils sont souvent composés de plusieurs 'elaborateComposant'..
 * Ils ont obligatoirement des modéles qui vont assembler les modeles filles pour concevoir notre business.
 * C'est seulement ici (dans un composant root) que les modèles peuvent se connaitres entre eux.
 * Ils ne sont cependant pas gadés en mémoire par le modele mère (root) car 
 *  une fois que les modèles filles se connaissent, ils communiquent entre eux sans avoir besoin du modèle mère.
 * 
 * Ici, chaque vue ne garde pas en mémoire sa présentation, une vue s'update en updatant ses vues filles.
 * En effet, les vues filles sont directement update a partir des présentations filles,
 *  présenations filles modifiées par la présentation mère.
 * 
 * Chaque vue doit implementer IVue, de facon a posséder a coup sur la fonction 'update'.
 * Chaque présentation doit heriter de 'Presentation', ce qui lui déclare un attribut 'vue' et les fonctions qui vont avec
 * Ici, une présentation NE PEUT PAS heriter de 'PresentationNotifier' (qui herite elle meme de presentation).
 * En effet, ici, si une présentation doit alerter qqchose, c'est forcément son modèle.
 * 
 * 
 * Remarque: Un pattern singleton aurait été partinant pour les composant root, comme ils sont focément uniques.
 * Mais on supose que cela n'est pas sensé arriver, de maniere a rendre le programme plus "lisible"
 * en gardant des architectures MVP a peu prés similaires.
 * 
 * 
 */
package com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootLogin;


