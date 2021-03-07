/**
 *
 * Ce package regroupe les composant graphiques évolués : un login , un plateur de jeu ...
 * Ils sont souvent composés de plusieurs 'basicComponant'.
 * Ils sont donc prévu a un effet particulier, ils doivent juste remplir un un role qui sera utile au business.
 * Ils ont dont obligatoirement des modéles qui vont consituer ensemble notre business (envoie de msg au serveur ...) 
 *  comme des petites briques.
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
 */
package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants;


