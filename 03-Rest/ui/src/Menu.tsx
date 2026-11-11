import React from "react";
import { NavLink } from "react-router-dom";
import "./Menu.css";

export default function Menu() {
    return (
		<nav>
			<NavLink exact to="/travellers-handbook-ui/">Home</NavLink>&nbsp;|&nbsp;
			<NavLink to="/travellers-handbook-ui/destinations">Destinations</NavLink>&nbsp;|&nbsp;
			<NavLink to="/travellers-handbook-ui/about">About</NavLink>
		</nav>
    )
}