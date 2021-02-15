/**
 * Ce package regroupe les composant graphiques de base : bouton, checnkbox, textfield ...
 * Ils ne sont donc prévu a aucun effet particulié, ils doivent juste remplir leur rôle primaire.
 * Ils n'ont donc pas de modéle.
 * Ici, chaque vue doit avoir en attribut (garder en mémoire) sa présentation,
 *  de maniere a pouvoir s'update en fonction de celle ci.
 * 
 * Chaque vue doit implementer IVue, de facon a posséder a coup sur la fonction 'update'.
 * Chaque présentation doit heriter de 'Presentation', ce qui lui déclare un attribut 'vue' et les fonctions qui vont avec
 * Une présentation peut aussi heriter de 'PresentationNotifier' (qui herite elle meme de presentation)
 *  ssi elle est ammené a notifier des listeners d'un événement particulier (un bouton qui previen avoir été préssé ...).
 * 
 * 
 */
package com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants;


