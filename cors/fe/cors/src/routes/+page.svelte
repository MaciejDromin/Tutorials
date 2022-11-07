<script lang="ts">
import { onMount } from "svelte"

    let resourceF:string = ""
    let resourceS:string = ""
    let resourceT:string = ""
    let resourceB:string = ""

    onMount(async () => {
        try {
            const response = await fetch("http://localhost:8080/cors", {
                method: "GET",
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                }
            })
            resourceF = await response.json()
        } catch(error) {
            console.log(error)
        }
        try {
            const responseS = await fetch("http://localhost:8080/class", {
                method: "GET",
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                }
            })
            resourceS = await responseS.json()
        } catch(error) {
            console.log(error)
        }
        try {
            const responseT = await fetch("http://localhost:8080/global", {
                method: "GET",
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                }
            })
            resourceT = await responseT.json()
        } catch(error) {
            console.log(error)
        }
        const responseB = await fetch("/api/cors", {
            method: "GET",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        })
        resourceB = await responseB.json()
    })
</script>
<p>Method Based:</p>
{#if resourceF !== ""}
    <p>{ resourceF.response }</p>
{:else}
    <p>I got Rejected due to CORS!</p>
{/if}

<p class="mt">Request going through Svelte Kit Server:</p>
{#if resourceB !== ""}
    <p>{ resourceB.response }</p>
{:else}
    <p>I got Rejected due to CORS!</p>
{/if}

<p class="mt">Class Based:</p>
{#if resourceS !== ""}
    <p>{ resourceS.response }</p>
{:else}
    <p>I got Rejected due to CORS!</p>
{/if}

<p class="mt">Global:</p>
{#if resourceT !== ""}
    <p>{ resourceT.response }</p>
{:else}
    <p>I got Rejected due to CORS!</p>
{/if}

<style>
.mt {
    margin-top: 36px;
}
</style>