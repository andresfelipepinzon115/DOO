/**
 * v0 by Vercel.
 * @see https://v0.dev/t/QoaANpOisQV
 * Documentation: https://v0.dev/docs#integrating-generated-code-into-your-nextjs-app
 */
import { SelectValue, SelectTrigger, SelectItem, SelectContent, Select } from "@/components/ui/select"
import { Input } from "@/components/ui/input"
import { Button } from "@/components/ui/button"
import { CardTitle, CardDescription, CardHeader, CardContent, CardFooter, Card } from "@/components/ui/card"

export default function Component() {
  return (
    <div key="1" className="w-full max-w-4xl mx-auto p-6 sm:p-8 bg-white rounded-lg shadow-lg dark:bg-gray-900">
      <h1 className="text-2xl font-bold mb-6 text-center dark:text-white">Reserva de Aulas UBICO</h1>
      <div className="mt-8">
        <div className="flex items-center justify-between mb-4">
          <h2 className="text-xl font-bold dark:text-white mt-8">Aulas Disponibles</h2>
        </div>
        <form className="grid grid-cols-1 md:grid-cols-3 gap-6 mt-4">
          <div className="space-y-2">
            <label className="text-sm font-medium text-gray-700 dark:text-gray-300" htmlFor="block">
              Bloque
            </label>
            <Select id="block">
              <SelectTrigger>
                <SelectValue placeholder="Selecciona un bloque" />
              </SelectTrigger>
              <SelectContent>
                <SelectItem value="block1">Bloque 1</SelectItem>
                <SelectItem value="block2">Bloque 2</SelectItem>
                <SelectItem value="block3">Bloque 3</SelectItem>
                <SelectItem value="block4">Bloque 4</SelectItem>
              </SelectContent>
            </Select>
          </div>
          <div className="space-y-2">
            <label className="text-sm font-medium text-gray-700 dark:text-gray-300" htmlFor="capacity">
              Capacidad
            </label>
            <Input id="capacity" placeholder="Ingresa la capacidad" type="text" />
          </div>
          <div className="space-y-2">
            <label className="text-sm font-medium text-gray-700 dark:text-gray-300" htmlFor="name">
              Nombre del Aula
            </label>
            <Input id="name" placeholder="Ingresa el nombre del aula" type="text" />
          </div>
          <div className="col-span-3 flex justify-end">
            <Button variant="outline">Agregar Aula</Button>
          </div>
        </form>
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6 mt-4">
          <Card>
            <CardHeader>
              <CardTitle>Aula 101</CardTitle>
              <CardDescription>Bloque 1</CardDescription>
            </CardHeader>
            <CardContent>
              <div className="flex justify-between">
                <p className="text-gray-500 dark:text-gray-400">Capacidad:</p>
                <p>30</p>
              </div>
            </CardContent>
            <CardFooter className="flex justify-between">
              <Button variant="outline">Editar</Button>
              <Button variant="destructive">Eliminar</Button>
            </CardFooter>
          </Card>
          <Card>
            <CardHeader>
              <CardTitle>Aula 201</CardTitle>
              <CardDescription>Bloque 2</CardDescription>
            </CardHeader>
            <CardContent>
              <div className="flex justify-between">
                <p className="text-gray-500 dark:text-gray-400">Capacidad:</p>
                <p>40</p>
              </div>
            </CardContent>
            <CardFooter className="flex justify-between">
              <Button variant="outline">Editar</Button>
              <Button variant="destructive">Eliminar</Button>
            </CardFooter>
          </Card>
          <Card>
            <CardHeader>
              <CardTitle>Aula 301</CardTitle>
              <CardDescription>Bloque 3</CardDescription>
            </CardHeader>
            <CardContent>
              <div className="flex justify-between">
                <p className="text-gray-500 dark:text-gray-400">Capacidad:</p>
                <p>50</p>
              </div>
            </CardContent>
            <CardFooter className="flex justify-between">
              <Button variant="outline">Editar</Button>
              <Button variant="destructive">Eliminar</Button>
            </CardFooter>
          </Card>
          <Card>
            <CardHeader>
              <CardTitle>Aula 401</CardTitle>
              <CardDescription>Bloque 4</CardDescription>
            </CardHeader>
            <CardContent>
              <div className="flex justify-between">
                <p className="text-gray-500 dark:text-gray-400">Capacidad:</p>
                <p>60</p>
              </div>
            </CardContent>
            <CardFooter className="flex justify-between">
              <Button variant="outline">Editar</Button>
              <Button variant="destructive">Eliminar</Button>
            </CardFooter>
          </Card>
        </div>
      </div>
    </div>
  )
}