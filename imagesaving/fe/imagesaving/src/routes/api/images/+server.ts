/** @type {import('./$types').RequestHandler} */
export async function PUT(event:any) {
    const body = await event.request.formData()
    const data = new FormData()
    data.append('file', body.get('file'))
    const response = await fetch("http://localhost:8080/images", {
        method: "PUT",
        body: data,
        headers: {
            'Accept': 'application/json'
        }
    })
    return response
}