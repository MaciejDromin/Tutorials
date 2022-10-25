<script lang="ts">
    import { onMount } from "svelte";
    import User from "$lib/User.svelte";
    import CreateUser from "$lib/CreateUser.svelte";
    interface User {
        id:number,
        uuid:string,
        name:string,
        imgSrc:string
    }

    let users:User[] = []

    onMount(async () => {
        const response = await fetch("/api/users", {
            method: "GET",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        })
        users = await response.json()
    })
    
</script>

<h1 class="container mx-auto my-20">
    <CreateUser />
    <div class="grid grid-flow-row">
        {#each users as user}
            <User id={ user.id } name={ user.name } imgSrc={ user.imgSrc }/>
        {/each}
    </div>
</h1>
