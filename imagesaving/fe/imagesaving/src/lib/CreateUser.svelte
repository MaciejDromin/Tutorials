<script lang="ts">
    let name:string
    let files:FileList

    const save = async () => {
        const data = new FormData()
        data.append('file', files[0])
        const imageUploadResponse = await fetch("/api/images", {
            method: "PUT",
            body: data,
            headers: {
                'Accept': 'application/json'
            }
        })
        const userCreatedResponse = await fetch("/api/users", {
            method: "POST",
            body: JSON.stringify({
                name: name,
                imgSrc: (await imageUploadResponse.json()).url
            }),
            headers: {
                'Accept': 'application/json'
            }
        })
    }
</script>
<div>
    <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
    type="text" placeholder="Name" bind:value={ name }/>
    <input type="file" accept="image/png" class="btn" bind:files/>
    <button class="btn" on:click={save}>Save</button>
</div>