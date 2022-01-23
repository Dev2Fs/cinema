package fr.filRouge.reservation.ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.filRouge.reservation.bll.ReservationManager;
import fr.filRouge.reservation.bo.Reservation;
import fr.filRouge.reservation.bo.Seance;

@Controller
public class ReservationController {
	@Autowired
	ReservationManager manager;

	@GetMapping("/index")
	public String index(Model model) {

		return "index";
	}

	@GetMapping("/reservations")
	public String reservations(Model model) {
		model.addAttribute("reservations", manager.getAllReservation());
		return "reservations";
	}

	@GetMapping("/add/{id}")
	public String add(@PathVariable("id") Integer seanceid) {
		Reservation reservation = new Reservation(manager.getSeanceByID(seanceid));
		manager.addReservation(reservation);
		return "redirect:/reserve/{id}";
	}
//	@GetMapping("/add")
//	public String add(Model model) { // ) rajouter dans la parenthèse, après model : , Reservation reservation
//		// j'envoie un attribut id à 0 pour que l'url de retour du formulaire soit
//		// conforme à celle du modify
////		model.addAttribute("id", 0); 
////		model.addAttribute("mode", "add");
//		
//		return "ajout";
//	}

	@GetMapping("/modify/{id}")
	public String modify(Model model, @PathVariable("id") Integer id, Reservation reservation) {
		reservation = manager.getReservationById(id); // en faisant cela je change l'adresse de l'objet module il n'est
														// donc plus lié au modéle
		model.addAttribute("mode", "modify");
		model.addAttribute("reservation", reservation); // je suis obligé de le remettre dans le modèle
		model.addAttribute("id", id);
		return "modifier";
	}

//
//	@GetMapping("/show/{id}")
//	public String show(Model model, @PathVariable("id") Integer id) {
//		Reservation reservation = manager.getReservationById(id);
//		model.addAttribute("reservation", reservation);
//		model.addAttribute("mode", "show");
//		return "ajout";
//	}
	@GetMapping("/show/{id}")
	public String show(@PathVariable("id") Integer id, Model model) {
		Seance seance = manager.getSeanceByID(id);
		model.addAttribute("seance", seance);
		model.addAttribute("nombre", manager.getReservationSeance(manager.getSeanceByID(id)).size());
		return "show";
	}

//	@GetMapping("/delete/{id}")
//	public String delete(@PathVariable("id") Integer id) {
//		manager.delReservationById(id);
//		return "redirect:/reservations";
//	}
	@GetMapping("/seances")
	public String seances(Model model) {
		model.addAttribute("seances", manager.getAllSeance());
		return "seances";
	}

	@GetMapping("/reserve/{id}")
	public String getReservationSeance(@PathVariable("id") Integer seanceid, Model model) {
		model.addAttribute("seance", manager.getSeanceByID(seanceid));
		model.addAttribute("nombre", manager.getReservationSeance(manager.getSeanceByID(seanceid)).size());
		model.addAttribute("reserves", manager.getReservationSeance(manager.getSeanceByID(seanceid)));
		return "reserve";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer reservid) {
		manager.delReservationById(reservid);
		return "redirect:/reservations";
	}
//	
//	@PostMapping("/valid/{mode}/{id}")
//	public String valid(Model model, @Valid Reservation reservation, BindingResult result, @PathVariable String mode,
//			@PathVariable Integer id) {
//		if (result.hasErrors()) {
//			return "ajout";
//		}
//		if ("add".equals(mode)) {
//			manager.addReservation(reservation);
//		} else if ("modify".equals(mode)) {
//			reservation.setId(id); // le module récupéré n'a pas d'id (ce n'est pas un champs de formulaire,
//									// je le regrèffe donc au module
//			manager.modReservation(reservation);
//		}
//		return "redirect:/reservations";
//	}

}