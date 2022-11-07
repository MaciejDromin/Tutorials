/** @type {import('./$types').RequestHandler} */
export async function GET({ url }:any) {
    const response = await fetch("http://localhost:8080/cors", {
        method: "GET",
        headers: {
            'Accept': 'application/json'
        }
    })
    return response
}