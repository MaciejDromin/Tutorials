import { error } from '@sveltejs/kit';
 
/** @type {import('./$types').RequestHandler} */
export async function GET({ url }:any) {
    const response = await fetch("http://localhost:8080", {
        method: "GET",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    })
    return response;
}

/** @type {import('./$types').RequestHandler} */
export async function POST(event:any) {
    const data = await event.request.json()
    console.log(data)
    const response = await fetch("http://localhost:8080", {
        method: "POST",
        body: JSON.stringify(data),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    })
    return response;
}