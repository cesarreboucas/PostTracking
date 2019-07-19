"use strict";

function formatDate(date) {
	let months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
	let days = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
	return date.getDate()+"-"+months[date.getMonth()]+"-"+date.getFullYear()+" "+
			date.getHours().toString().padStart(2,"0")+":"
			+date.getMinutes().toString().padStart(2,"0")+" ("+days[date.getDay()]+")";
}